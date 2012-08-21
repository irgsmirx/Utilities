/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

/**
 *
 * @author tobias
 */
public class StringBuilderRenderer implements ICharRenderer {
	
	private StringBuilder stringBuilder;
	
	public StringBuilderRenderer(StringBuilder sb) {
		this.stringBuilder = sb;
	}

	@Override
	public void render(char c) {
		stringBuilder.append(c);
	}

  @Override
	public void render(String s) {
		stringBuilder.append(s);
	}
	
  @Override
	public void render(Object o) {
		stringBuilder.append(o);
	}
	
}
