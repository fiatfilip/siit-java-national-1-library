package org.example;

public class ArtAlbum extends Book{
    private String paperQuality;

    public ArtAlbum(String name, Integer numberOfPages, String paperQuality){
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum{" +
                super.toString() +
                "paperQuality='" + paperQuality + '\'' +
                '}';
    }
}
