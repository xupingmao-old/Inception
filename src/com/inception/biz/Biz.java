package com.inception.biz;

import java.sql.SQLException;
import java.util.List;

import com.inception.dao.AlbumDao;
import com.inception.dao.HistoryDao;
import com.inception.dao.MusicDao;
import com.inception.dao.PreferenceDao;
import com.inception.dao.UserDao;
import com.inception.dao.UserExistsException;
import com.inception.entity.Album;
import com.inception.entity.History;
import com.inception.entity.Music;
import com.inception.entity.Preference;
import com.inception.entity.User;
import com.inception.entity.UserLog;

public class Biz {
	private UserDao userDao;
	private MusicDao musicDao;
	private HistoryDao historyDao;
	private AlbumDao albumDao;
	private PreferenceDao preferenceDao;
	private static Biz self = null;
	
	public Biz(){
		userDao = new UserDao();
		musicDao = new MusicDao();
		historyDao = new HistoryDao();
		albumDao = new AlbumDao();
		preferenceDao = new PreferenceDao();
	}
	
	public static Biz newInstance(){
		if( self == null){
			self = new Biz();
		}
		return self;
	}
	
	public void userRegistDefault(User user) throws SQLException, UserExistsException{
		userDao.userSaveDefault(user);
	}
	
	public void userRegistByEmail(User user) throws SQLException, UserExistsException{
		userDao.userSaveByEmail(user);
	}
	
	public int getUsersCount() throws SQLException{
		return userDao.getUsersCount();
	}
	public User findUserByEmail(String email) throws SQLException{
		return userDao.userListByEmail(email);
	}
	
	public User findUserById(int id) throws SQLException{
		return userDao.userListByUserId(id);
	}
	
	public void deleteUserById(int id)throws SQLException{
		userDao.delteUserById(id);
	}
	
	public List<User> findAllUsers() throws SQLException{
		return userDao.userListAll();
	}
	
	public List<User> findUsersLimit(int start, int size) throws SQLException{
		return userDao.userListLimit(start, size);
	}
	
	public void saveUserByEmail(User user) throws SQLException, UserExistsException{
		userDao.userSaveByEmail(user);
	}
	
	public void writeUserLog(UserLog log) throws SQLException{
		userDao.writeLog(log);
	}

	public List<Music> listMusicLimit(int start, int count) throws SQLException{
		return musicDao.listMusicLimit(start, count);
	}
	
	public List<Music> getTopMusic(int start, int count) throws SQLException{
		return musicDao.getTop(start,count);
	}

	public List<Music> getLatestMusic(int start, int count) throws SQLException{
		return musicDao.getLatest(start, count);
	}
	public void makeSuperUser(int id) throws SQLException{
		userDao.makeSuperUser(id);
	}
	
	public void musicSave(Music m) throws SQLException{
		musicDao.musicSave(m);
	}

	public int getMusicCount() throws SQLException{
		return userDao.getMusicCount();
	}

	public Music findMusicById(int id) throws SQLException{
		return musicDao.getMusicById(id);
	}

	public void deleteMusicById(int id) throws SQLException{
		musicDao.deleteMusicById(id);
	}

	public void updateUser(User user) throws SQLException{
		userDao.updateUser(user);
	}

	public void musicCTRInc(String url) throws SQLException{
		musicDao.musicCTRInc(url);
	}

	public Music findMusicByUrl(String url) throws SQLException{
		return musicDao.findMusicByUrl(url);
	}

	public void addHistory(int userId, int musicId) throws SQLException{
		historyDao.add(userId, musicId);
	}

	public void addHistory(int uid, String url) throws SQLException{
		Music m = this.findMusicByUrl(url);
		if( m == null ){
			return;
		}
		this.addHistory(uid, m.getId());
	}

	public List<History> getHistoryLimit(int uid, int start, int size) throws SQLException {
		return historyDao.getHistoryLimit(uid, start, size);
	}

	public void updateMusicBasicInfo(Music music) throws SQLException {
		musicDao.updateBaiscInfo(music);
	}

	public void updateUserHead(User user, String newFileName) throws SQLException{
		userDao.updateUserHead(user, newFileName);
	}

	public void updateMusicImage(Music m) throws SQLException{
		musicDao.updateMusicImage(m);
	}

	public void makeNormalUser(int id) throws SQLException {
		userDao.makeNormalUser(id);
	}
	
	public int getAlbumCount() throws SQLException{
		return albumDao.getArtistCount();
	}

	public void updatePasswd(int id, String passwd) throws SQLException{
		userDao.updatePasswd(id, passwd);
	}

	public List<Album> getAlbumList(int start, int size)  throws SQLException{
		return albumDao.getList(start, size);
	}

	public void addAlbum(Album al) throws SQLException{
		albumDao.add(al);
	}

	public String getLrc(String url) throws SQLException{
		return musicDao.getLrc(url);
	}

	public void updateMusicLrc(int id, String lrc) throws SQLException{
		musicDao.updateLrc(id, lrc);
	}

	public Album findAlbumById(int aid) throws SQLException{
		return albumDao.findAlbumById(aid);
	}

	public void updateAlbumImg(Album al) throws SQLException{
		albumDao.updateImg(al);
	}
	
	public void updateAlbum(Album al) throws SQLException{
		albumDao.update(al);
	}
	
	public List<String> getAlbumNames() throws SQLException{
		return albumDao.getNames();
	}

	public Music getLastMusic() throws SQLException{
		return musicDao.getLast();
	}

	public void deleteAlbumById(int id) throws SQLException {
		albumDao.delete(id);
	}

	public List<Music> getMusicListByAlbum(String album) throws SQLException{
		return musicDao.getListByAlbum(album);
	}

	public boolean isPrefered(int userId, int musicId) throws SQLException{
		return preferenceDao.has(userId, musicId);
	}
	
	public void preferMusic(int userId, int musicId) throws SQLException{
		preferenceDao.add(userId, musicId);
	}

	public void deletePrefer(int userId, int musicId) throws SQLException{
		preferenceDao.delete(userId, musicId);
	}

	public List<Preference> getPreferList(int userId, int start, int size) throws SQLException{
		return preferenceDao.getPreferenceLimit(userId, start, size);
	}

	public int getPreferCount(int i) throws SQLException{
		return preferenceDao.getCount(i);
	}

	public void deletePrefer(int id) throws SQLException {
		preferenceDao.delete(id);
	}

	public List<Music> getAllPrefer(int id) throws SQLException {
		return preferenceDao.getAllMusic(id);
	}

	public int getHistoryCount(int id) throws SQLException{
		return historyDao.getCount(id);
	}
}
