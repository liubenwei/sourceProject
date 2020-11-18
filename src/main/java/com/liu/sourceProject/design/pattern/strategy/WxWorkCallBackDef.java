package com.liu.sourceProject.design.pattern.strategy;

public interface WxWorkCallBackDef {
	enum ChangeType {
		// @formatter:offa
		update_user,
		create_user,
		delete_user,
		create_party,
		update_party,
		delete_party;

	}

	enum Event {
		// @formatter:off
		change_contact("change_contact"),

		;
		// @formatter:on
		Event(String name) {
			this.name = name;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
