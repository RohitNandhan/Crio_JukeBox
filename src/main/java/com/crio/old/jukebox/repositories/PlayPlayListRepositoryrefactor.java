package com.crio.old.jukebox.repositories;//package com.crio.jukebox.repositories;
//
//import com.crio.jukebox.entites.PlayAction;
//import com.crio.jukebox.entites.PlayPlaylist;
//import com.crio.jukebox.entites.Song;
//
//import java.util.*;
//
//public class PlayPlayListRepositoryrefactor implements IPlayPlayListRepository {
//    private final Map<String, List<PlayPlaylist>> playPlaylistMap;
//    private PlayPlaylist currentPlayList;
//    private String currentSongId;
// //   private int iterator;
//
//    public PlayPlayListRepositoryrefactor() {
//        this.playPlaylistMap = new LinkedHashMap<>();
//    }
//
//    public boolean checkPlaylistById(String id){
//        if(playPlaylistMap.values().stream().flatMap(List::stream).anyMatch(e->id.equals(e.getPlaylistId()))) {
//            return true;
//        }else return false;
//    }
//
//    public PlayPlaylist getPlaylistById(String id) {
//        if(checkPlaylistById(id)){
//            playPlaylistMap.get(id).get(id).getPlaylistId(id);
//            return playPlaylistMap.values().stream().flatMap(List::stream).filter(e -> id.equals(getPlaylistById(id))).findFirst().get();
//        }else {
//            //throw exception;
//            return null;
//        }
//
//        }
//
//    public Song play(String userId) {
//       // currentPlayList=playPlaylistMap.get(userId).stream().;
//        currentSongId=currentPlayList.getCurrentSong().getId();
//        return currentPlayList.getSongById(currentSongId);
//    }
//
//    private Song playSongByID(String userId, String songId){
//      //  if(currentPlayList)
//        currentSongId=songId;
//        return currentPlayList.getSongById(songId);
//    }
//
//
//    public void addPlayingPlaylist(String userID, PlayPlaylist playPlaylist) {
//            if(playPlaylistMap.containsKey(userID)){
//                //add playlist
//                if(!checkPlaylistById(playPlaylist.getPlaylistId())) {
//                    playPlaylistMap.put(userID,playPlaylistMap)
//                }
//
//            }else{
//                playPlaylistMap.put(userID,new ArrayList<>(Arrays.asList(playPlaylist)));
//            }
//          currentPlayList=playPlaylist;
//        //    currentPlayList=playPlaylistMap.get(userID);
//    }
//    @Override
//    public Song play(String userId, String action) {
//        Iterator<String> itr=currentPlayList.getSongList().stream().map(e->e.getId()).iterator();
//        String id=currentSongId;
//        String songId=null;
//        if(PlayAction.valueOf(action)==PlayAction.NEXT){
//           songId = findNext(id,itr);
//            return currentPlayList.getSongById(songId);
//        }else if(PlayAction.valueOf(action)==PlayAction.BACK){
//            songId = findPrev(id,itr);
//            return currentPlayList.getSongById(songId);
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
//    public boolean checkPlaylist(String userid){
//        if(currentPlayList==playPlaylistMap.get(userid)){
//            return true;
//        }else {
//           // currentPlayList=playPlaylistMap.get(userid);
//            return false;
//        }
//    }
//}
