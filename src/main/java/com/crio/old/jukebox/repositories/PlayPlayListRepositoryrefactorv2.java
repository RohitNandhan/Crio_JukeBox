package com.crio.old.jukebox.repositories;//package com.crio.jukebox.repositories;
//
//import com.crio.jukebox.entites.*;
//
//import java.util.*;
//
//public class PlayPlayListRepositoryrefactorv2 implements IPlayPlayListRepositoryRefactor {
//    private final Map<String, PlayPlaylistRefactored> playPlaylistMap;
//    private Playlist currentPlayList;
//    private PlayPlaylistRefactored currentPlayPlaylist;
//    private String currentSongId;
// //   private int iterator;
//
//    public PlayPlayListRepositoryrefactorv2() {
//        this.playPlaylistMap = new LinkedHashMap<>();
//    }
//
//    @Override
//    public boolean checkPlaylistById(String id){
//        if(currentPlayPlaylist.getPlaylists().stream().anyMatch(e->e.getId()==id))
//            return true;
//        else return false;
//    }
//
////    public PlayPlaylist getPlaylistById(String id) {
////        if(checkPlaylistById(id)){
////            return playPlaylistMap.values().stream().flatMap(List::stream).filter(e -> id.equals(getPlaylistById(id))).findFirst().get();
////        }else {
////            //throw exception;
////        }
////
////        }
//
//    @Override
//    public Song play(String userId) {
//       // currentPlayList=playPlaylistMap.get(userId).stream().;
//        currentPlayPlaylist=playPlaylistMap.get(userId);
//        currentSongId=currentPlayPlaylist.getCurrentSong(currentPlayList).getId();
//        return currentPlayPlaylist.getSongById(currentPlayList,currentSongId);
//    }
//
//    private Song playSongByID(String userId, String songId){
//      //  if(currentPlayList)
//        currentSongId=songId;
//        return currentPlayPlaylist.getSongById(currentPlayList,songId);
//    }
//
//
//    @Override
//    public void addPlayingPlaylist(String userID, Playlist playlist) {
//        PlayPlaylistRefactored ply;
//            if(playPlaylistMap.containsKey(userID)){
//                //throws exception
//                if(!checkPlaylistById(playlist.getId()))
//                playPlaylistMap.get(userID).addPlayList(playlist);
//            }else{
//               ply= new PlayPlaylistRefactored(userID,new ArrayList<>(Arrays.asList(playlist)));
//                playPlaylistMap.put(userID,ply);
//                currentPlayPlaylist=ply;
//            }
//          currentPlayList=playlist;
//
//        //    currentPlayList=playPlaylistMap.get(userID);
//    }
//
//    @Override
//    public Song play(String userId, String action) {
//        Iterator<String> itr=currentPlayList.getSongs().stream().map(e->e.getId()).iterator();
//        String id=currentSongId;
//        String songId=null;
//        if(PlayAction.valueOf(action)==PlayAction.NEXT){
//           songId = findNext(id,itr);
//            return currentPlayPlaylist.getSongById(currentPlayList,songId);
//        }else if(PlayAction.valueOf(action)==PlayAction.BACK){
//            songId = findPrev(id,itr);
//            return currentPlayPlaylist.getSongById(currentPlayList,songId);
//        }else {
//            return playSongByID(userId, action);
//        }
//    }
//    private String findPrev(String id,Iterator<String> itr){
//        while (itr.hasNext()){
//            String prev;
//            if((prev= itr.next())==id){
//                while(itr.hasNext()){
//                    prev= itr.next();
//                }return prev;
//            }
//            if(itr.next()==id){
//                return prev;
//            }
//        } return id;
//    }
//    private String findNext(String id,Iterator<String> itr){
//        String start=null;
//        if(itr.hasNext())
//            start =itr.next();
//        if(start==id){
//            return itr.next();
//        }
//        while (itr.hasNext()) {
//            if ((itr.next())==id) {
//                if (itr.hasNext())
//                    return  itr.next();
//            }
//        } return start;
//
//    }
//
//
//    @Override
//    public boolean checkPlaylist(String userid){
//        if(currentPlayPlaylist==playPlaylistMap.get(userid)){
//            return true;
//        }else {
//           // currentPlayList=playPlaylistMap.get(userid);
//            return false;
//        }
//    }
//}
