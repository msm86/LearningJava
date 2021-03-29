package interfaces;

public class DeskPhone implements ITelephone{
	private double myNumber;
	private boolean isRinging;
	private boolean isOn;
	private boolean answering;
	
	public DeskPhone(double myNumber) {
		this.myNumber = myNumber;
		this.isRinging = false;
		this.isOn = false;
		this.answering = false;
	}
	
	@Override
	public void powerOn() {
		if(this.isOn)
			System.out.println("Phone is already on");
		else{
			System.out.println("Phone is on now");
			this.isOn = true;
		}
	}
	
	@Override
	public boolean isRinging() {
		if(this.isOn) {
			System.out.println("Phone is ringing");
			this.isRinging = true;
			return true;
		}
		else
			return false;
	}
	
	@Override
	public void answerPhone() {
		if(this.isRinging) {
			System.out.println("Phone answered");
			this.isRinging = false;
			this.answering = true;
		}
		else
			System.out.println("Dial Tone heard...");
	}
	
	@Override
	public void endPhone() {
		if(this.answering) {
			System.out.println("End phone.");
			this.answering = false;
		}
		else
			System.out.println("Cant end a phone if not answering");
	}

	@Override
	public void dialPhone(int phoneNumber) {
		if(!answering) {
			System.out.println("Dial the number");
		}
	}	
}
