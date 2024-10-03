package object;

public interface NeedKey {
    public void setKey(int keyNum);
    public void lock(int keyNum);
    public void unlock(int keyNum);
    public boolean checkIsLocked();
}
