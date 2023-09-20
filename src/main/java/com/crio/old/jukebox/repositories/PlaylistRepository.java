package com.crio.old.jukebox.repositories;//package com.crio.jukebox.repositories;
//
//import com.crio.jukebox.entites.Playlist;
//import com.crio.jukebox.entites.Song;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PlaylistRepository implements IPlaylistRepository {
//    private final Map<String,Playlist> playlistMap;
//    private int Pointer;
//
//    public PlaylistRepository() {
//        this.playlistMap = new LinkedHashMap<>();
//    }
//
//    @Override
//    public void savePlaylist(String userId,Playlist playlist) {
//        playlistMap.put(userId,playlist);
//    }
//
//    @Override
//    public Playlist getPlaylistBy(String playlistId) {
//        return playlistMap.get(playlistId);
//    }
//
//    @Override
//    public void deletePlaylist(Playlist playlist) {
//        playlistMap.remove(playlist);
//    }
//
//    @Override
//    public void addSong(String playlistId, List<Song> songList) {
//        songList.stream().forEach(song -> {
//            if (!(playlistMap.get(playlistId).getSongs().contains(song))) {
//                playlistMap.get(playlistId).addSong(song);
//            }
//        });
//    }
//        @Override
//        public void deleteSong(String playlistId, List<Song> songList) {
//            songList.stream().forEach(song -> {
//                if((playlistMap.get(playlistId).getSongs().contains(song))){
//                    playlistMap.get(playlistId).removeSong(song);
//                }
//            });
//
//    }
//
//
//
//}
