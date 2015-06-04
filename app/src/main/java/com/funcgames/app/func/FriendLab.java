package com.funcgames.app.func;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class FriendLab {

    private static ArrayList<Friend> mFriends;

    private static FriendLab sFriendLab;
    private Context mAppContext;

    private static final String TAG = "FriendLab";
    private static final String FILENAME = "friends.json";


    private FriendLab(Context appContext){
        mAppContext = appContext;
        refresh();
    }

    public void refresh() {
        mFriends = new ArrayList<Friend>();
        Friend friend = null;
        ContentResolver cr = mAppContext.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int limit = 0;
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                if(limit < 17) {
                    String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        pCur.close();
                    }
                    friend = new Friend();
                    friend.setName(name);
                    friend.setId(id);
                    friend.setName(name);
                    mFriends.add(friend);
                }
                limit += 1;
            }
        }
    }

    public static FriendLab get(Context c){
        if(sFriendLab == null)
            sFriendLab = new FriendLab(c);
        return sFriendLab;
    }

    public static ArrayList<Friend> getFriends(){
        return mFriends;
    }

    public static Friend getFriendById(String id){
        for(Friend friend : mFriends){
            if(friend.getId().equals(id))
                return friend;
        }
        return null;
    }

    public static Friend getFriendByNumber(String number){
        for(Friend friend : mFriends){
            if(friend.getNumber().equals(number))
                return friend;
        }
        return null;
    }

}
