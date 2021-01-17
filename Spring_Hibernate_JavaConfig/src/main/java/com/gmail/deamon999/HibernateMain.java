package com.gmail.deamon999;


import java.util.List;

import com.gmail.deamon999.config.AppConfig;
import com.gmail.deamon999.entities.Singer;
import com.gmail.deamon999.repositories.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class HibernateMain {

    private static Logger logger = LoggerFactory.getLogger(HibernateMain.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        Singer singer = singerDao.findAll().get(0);
        logger.info(singer.toString());

        singerDao.delete(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
        ctx.close();
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(s -> {
            logger.info(s.toString());
            if (s.getAlbums() != null) {
                s.getAlbums().forEach(a -> logger.info("\t" + a.toString()));
            }
            if (s.getInstruments() != null) {
                s.getInstruments().forEach(i -> logger.info("\tInstrument: " + i.getInstrumentName()));
            }
        });
    }
}
