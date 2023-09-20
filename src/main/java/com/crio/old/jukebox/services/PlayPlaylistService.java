package com.crio.old.jukebox.services;//package com.crio.jukebox.services;
//
//import com.crio.jukebox.dto.PlayResponse;
//import com.crio.jukebox.entites.*;
//import com.crio.jukebox.repositories.IPlayPlayListRepository;
//import com.crio.jukebox.repositories.IPlaylistRepositoryD;
//import com.crio.jukebox.repositories.ISongRepository;
//import com.crio.jukebox.repositories.IUserRepository;
//
//import java.util.List;
//
//public class PlayPlaylistService implements IPlayPlaylist {
//    private IUserRepository userRepository;
//    private ISongRepository songRepository;
//    private IPlaylistRepositoryRefactor playlistRepository;
//    private IPlayPlayListRepository playPlaylistRepository;
//
//
//
//    public PlayPlaylistService(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepositoryD playlistRepository, IPlayPlayListRepository playPlaylistRepository) {
//        this.userRepository = userRepository;
//        this.songRepository = songRepository;
//        this.playlistRepository = playlistRepository;
//        this.playPlaylistRepository=playPlaylistRepository;
//    }
//    @Override
//    public List<Song> getSongsByPlaylistId(String playlistId) {
//        return null;
//    }
//
//    @Override
//    public List<Song> getSongsByPlaylistName(String playlistName) {
//        return null;
//    }
//
//    @Override
//    public PlayResponse playPlaylist(String userId, String playListId) {
//       Playlist playlist=playlistRepository.getPlaylistById(playListId);
//        User user=userRepository.getUserById(userId);
//        PlayPlaylist playPlaylist=new PlayPlaylist(user,playlist);
//        playPlaylistRepository.addPlayingPlaylist(userId,playPlaylist);
//       Song song= playPlaylistRepository.play(userId);
//        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
//    }
//    @Override
//    public PlayResponse playSong(String userID, String action){
//      Song song =  playPlaylistRepository.play(userID,action);
//        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
//            }
//
//}
