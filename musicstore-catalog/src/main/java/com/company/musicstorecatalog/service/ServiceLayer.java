package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.repository.AlbumRepository;
import com.company.musicstorecatalog.repository.ArtistRepository;
import com.company.musicstorecatalog.repository.LabelRepository;
import com.company.musicstorecatalog.repository.TrackRepository;
import com.company.musicstorecatalog.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;
    private TrackRepository trackRepository;

    @Autowired
    public ServiceLayer(AlbumRepository albumRepository, ArtistRepository artistRepository,
                        LabelRepository labelRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.trackRepository = trackRepository;
    }

    public ServiceLayer(LabelRepository repo) {
    }

    public ServiceLayer(AlbumRepository repo) {

    }

  //  public ServiceLayer(AlbumViewModel view) {
    //}

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {

        // Persist Album
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a = albumRepository.save(a);
        viewModel.setId(a.getId());

        // Add Album Id to Tracks and Persist Tracks
        List<Track> tracks = viewModel.getTracks();

        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    trackRepository.save(t);
                });

        tracks = trackRepository.findAllTracksByAlbumId(viewModel.getId());
        viewModel.setTracks(tracks);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id) {

        // Get the album object first
        Optional<Album> album = albumRepository.findById((long) id);

        return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
    }

    private AlbumViewModel buildAlbumViewModel(Album album) {

        // Get the associated artist
        Optional<Artist> artist = artistRepository.findById(album.getArtistId());

        // Get the associated label
        Optional<Label> label = labelRepository.findById(album.getLabelId());

        // Get the tracks associated with the album
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());

        // Assemble the AlbumViewModel
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist.get());
        avm.setLabel(label.get());
        avm.setTracks(trackList);

        // Return the AlbumViewModel
        return avm;
    }

    public List<AlbumViewModel> findAllAlbums() {

        List<Album> albumList = albumRepository.findAll();

        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel) {

        // Update the album information
        Album album = new Album();
        album.setId(viewModel.getId());
        album.setArtistId(viewModel.getArtist().getId());
        album.setLabelId(viewModel.getLabel().getId());
        album.setListPrice(viewModel.getListPrice());
        album.setReleaseDate(viewModel.getReleaseDate());

        albumRepository.save(album);

        // We don't know if any track have been removed so delete all associated tracks
        // and then associate the tracks in the viewModel with the album
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());
        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        List<Track> tracks = viewModel.getTracks();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    t = trackRepository.save(t);
                });
    }

    @Transactional
    public void removeAlbum(int id) {

        // Remove all associated tracks first
        List<Track> trackList = trackRepository.findAllTracksByAlbumId((long) id);

        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        // Remove album
        albumRepository.deleteById((long) id);

    }
}
/*
 if (tShirtViewModel==null) throw new IllegalArgumentException("No TShirt is passed! TShirt object is null!");

        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtRepo.save(tShirt);

        return buildTShirtViewModel(tShirt);
 */