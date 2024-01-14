package ao.co.isptec.aplm.psfotosg10.network.service;

public interface LoginResultListener {
    void onLoginSuccess(int status, String token, int userID);
    void onLoginFailure(int errorCode);
}
