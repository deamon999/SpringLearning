package com.gmail.deamon999.config;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;

import com.gmail.deamon999.entities.Album;
import com.gmail.deamon999.entities.Instrument;
import com.gmail.deamon999.entities.Singer;
import com.gmail.deamon999.repositories.InstrumentDao;
import com.gmail.deamon999.repositories.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBInitializer {

    private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

    private final SingerDao singerDao;
    private final InstrumentDao instrumentDao;

    @Autowired
    public DBInitializer(SingerDao singerDao, InstrumentDao instrumentDao) {
        this.singerDao = singerDao;
        this.instrumentDao = instrumentDao;
    }

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");

        Instrument guitar = new Instrument();
        guitar.setInstrumentName("Guitar");
        instrumentDao.save(guitar);

        Instrument piano = new Instrument();
        piano.setInstrumentName("Piano");
        instrumentDao.save(piano);

        Instrument voice = new Instrument();
        voice.setInstrumentName("Voice");
        instrumentDao.save(voice);

        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date((new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
        singer.addInstrument(guitar);
        singer.addInstrument(piano);

        Album album1 = new Album();
        album1.setTitle("The Search For Everything");
        album1.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2017, 0, 20)).getTime().getTime()));
        singer.addAlbum(album1);

        Album album2 = new Album();
        album2.setTitle("Battle Studies");
        album2.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(2009, 10, 17)).getTime().getTime()));
        singer.addAlbum(album2);

        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("Eric");
        singer.setLastName("Clapton");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1945, 2, 30)).getTime().getTime()));
        singer.addInstrument(guitar);

        Album album = new Album();
        album.setTitle("From The Cradle");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1994, 8, 13)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Butler");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1975, 3, 1)).getTime().getTime()));
        singer.addInstrument(guitar);

        singerDao.save(singer);
        logger.info("Database initialization finished.");
    }
}


