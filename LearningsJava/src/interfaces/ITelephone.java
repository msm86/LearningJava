package interfaces;

public interface ITelephone {
	void powerOn();
	boolean isRinging();
	void answerPhone();
	void dialPhone(int phoneNumber);
	void endPhone();
}
