package org.jasig.cas.support.pac4j.plugin.facebook;

import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.profile.OAuthAttributesDefinition;
import org.pac4j.oauth.profile.converter.JsonConverters;
import org.pac4j.oauth.profile.facebook.FacebookConverters;

/**
 * Created by liutong on 2017/3/2.
 */
public class YcFacebookAttributesDefinition extends OAuthAttributesDefinition {
    /* 添加单点登录自定义属性 start*/
    public static final String USER_ID = "userId";
    public static final String LOGIN_NAME = "loginName";
    public static final String DOMAINNAME = "domainname";
    /* 添加单点登录自定义属性 end*/

    public static final String NAME = "name";
    public static final String FIRST_NAME = "first_name";
    public static final String MIDDLE_NAME = "middle_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String LOCALE = "locale";
    public static final String LANGUAGES = "languages";
    public static final String LINK = "link";
    public static final String USERNAME = "username";
    public static final String THIRD_PARTY_ID = "third_party_id";
    public static final String TIMEZONE = "timezone";
    public static final String UPDATED_TIME = "updated_time";
    public static final String VERIFIED = "verified";
    public static final String BIO = "bio";
    public static final String BIRTHDAY = "birthday";
    public static final String EDUCATION = "education";
    public static final String EMAIL = "email";
    public static final String HOMETOWN = "hometown";
    public static final String INTERESTED_IN = "interested_in";
    public static final String LOCATION = "location";
    public static final String POLITICAL = "political";
    public static final String FAVORITE_ATHLETES = "favorite_athletes";
    public static final String FAVORITE_TEAMS = "favorite_teams";
    public static final String QUOTES = "quotes";
    public static final String RELATIONSHIP_STATUS = "relationship_status";
    public static final String RELIGION = "religion";
    public static final String SIGNIFICANT_OTHER = "significant_other";
    public static final String WEBSITE = "website";
    public static final String WORK = "work";
    public static final String FRIENDS = "friends";
    public static final String MOVIES = "movies";
    public static final String MUSIC = "music";
    public static final String BOOKS = "books";
    public static final String LIKES = "likes";
    public static final String ALBUMS = "albums";
    public static final String EVENTS = "events";
    public static final String GROUPS = "groups";
    public static final String MUSIC_LISTENS = "music.listens";
    public static final String PICTURE = "picture";

    public YcFacebookAttributesDefinition() {
        final String[] names = new String[] {
                NAME, FIRST_NAME, MIDDLE_NAME, LAST_NAME, LINK, USERNAME, THIRD_PARTY_ID, BIO, EMAIL, POLITICAL, QUOTES,
                RELIGION, WEBSITE, USER_ID, LOGIN_NAME,DOMAINNAME
        };
        for (final String name : names) {
            addAttribute(name, Converters.stringConverter);
        }
        addAttribute(TIMEZONE, Converters.integerConverter);
        addAttribute(VERIFIED, Converters.booleanConverter);
        addAttribute(GENDER, Converters.genderConverter);
        addAttribute(LOCALE, Converters.localeConverter);
        addAttribute(UPDATED_TIME, Converters.dateConverter);
        addAttribute(BIRTHDAY, FacebookConverters.birthdayConverter);
        addAttribute(RELATIONSHIP_STATUS, FacebookConverters.relationshipStatusConverter);
        addAttribute(LANGUAGES, FacebookConverters.listObjectConverter);
        addAttribute(EDUCATION, FacebookConverters.listEducationConverter);
        addAttribute(HOMETOWN, FacebookConverters.objectConverter);
        addAttribute(INTERESTED_IN, JsonConverters.listStringConverter);
        addAttribute(LOCATION, FacebookConverters.objectConverter);
        addAttribute(FAVORITE_ATHLETES, FacebookConverters.listObjectConverter);
        addAttribute(FAVORITE_TEAMS, FacebookConverters.listObjectConverter);
        addAttribute(SIGNIFICANT_OTHER, FacebookConverters.objectConverter);
        addAttribute(WORK, FacebookConverters.listWorkConverter);
        addAttribute(FRIENDS, FacebookConverters.listObjectConverter, false);
        addAttribute(MOVIES, FacebookConverters.listInfoConverter, false);
        addAttribute(MUSIC, FacebookConverters.listInfoConverter, false);
        addAttribute(BOOKS, FacebookConverters.listInfoConverter, false);
        addAttribute(LIKES, FacebookConverters.listInfoConverter, false);
        addAttribute(ALBUMS, FacebookConverters.listPhotoConverter, false);
        addAttribute(EVENTS, FacebookConverters.listEventConverter, false);
        addAttribute(GROUPS, FacebookConverters.listGroupConverter, false);
        addAttribute(MUSIC_LISTENS, FacebookConverters.listMusicListensConverter, false);
        addAttribute(PICTURE, FacebookConverters.pictureConverter, false);
    }
}
