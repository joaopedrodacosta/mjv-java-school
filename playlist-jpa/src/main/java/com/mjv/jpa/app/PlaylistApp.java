package com.mjv.jpa.app;


import com.mjv.jpa.model.Musica;
import com.mjv.jpa.repository.MusicaJpaRepository;

public class PlaylistApp {
public static void main(String[]args) {


    MusicaJpaRepository mjr = new MusicaJpaRepository();
    Musica musica = new Musica();
    musica.setNome("Oceans");
    musica.setAlbum("Tell Me It's Real");
    musica.setArtista("Seafret");
    musica.setDuracao(3.35);
    musica.setCompositor("Harry Draper");
    musica.setGenero("Indie");
    musica.setInternacional(true);

    mjr.save(musica);
}
}
