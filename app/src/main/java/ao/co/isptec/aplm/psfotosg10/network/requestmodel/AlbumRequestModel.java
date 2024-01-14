package ao.co.isptec.aplm.psfotosg10.network.requestmodel;

public class AlbumRequestModel {
    private String name;
    private int user_id;
    private String caminho;

    public AlbumRequestModel(String name, int user_id, String caminho) {
        this.name = name;
        this.user_id = user_id;
        this.caminho = "albumUm/"+caminho;
    }
}
