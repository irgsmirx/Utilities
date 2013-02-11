package com.ramforth.utilities.triggering.implementation.actions;

  //[Serializable]
  public abstract class AbstractPathAction extends AbstractAction {

    protected String path = null;

    public String getPath() {
			return path;
		}
    
		public void setPath(String value) {
			this.path = value;
    }

  }