package scale;

import adapter.*;

public class EditOptions extends Thread {
		private BuildAuto auto;
		
		private String key;
		private String optionSet;
		private String option;
		
		public EditOptions(BuildAuto auto, String key, String optionSet, String option){
			this.auto = auto;
			this.key = key;
			this.optionSet = optionSet;
			this.option = option;
		}
		
		public void run(){
			auto.chooseOption(key, optionSet, option);
		}
		
}
