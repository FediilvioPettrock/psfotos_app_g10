package ao.co.isptec.aplm.psfotosg10.model;

public class Album {
    private String name;
    private int owner;
    private float numberOfPhotos;
    private int numberOfMembers;

    private String username;
    private int iduser;
    public String getName() {
        return name;
    }

    public int getOwner() {
        return owner;
    }

    public float getNumberOfPhotos() {
        return numberOfPhotos;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }
}
