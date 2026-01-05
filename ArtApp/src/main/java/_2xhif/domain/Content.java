package _2xhif.domain;

/**
 * An abstract base class for any content associated with POIs. A content may be an image, an audio file, a video,
 * a slideshow etc. It is anything that makes a POI 'visible' to a user.
 */
public abstract class Content {

    private final Long id;
    private final String name;
    private final String description;

    public Content(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Presents the content element to the user. Based on the type of content, this includes playing an audio,
     * showing a video or simply presenting one or more images.
     */
    abstract void present();

}
