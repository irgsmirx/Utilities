/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tobias
 */
public class OutputStreamRenderer implements ICharRenderer {
	
	private OutputStream outputStream;
	
	public OutputStreamRenderer(OutputStream os) {
		this.outputStream = os;
	}

	@Override
	public void render(char c) {
		try {
			outputStream.write(c);
		} catch (IOException ioex) {
			Logger.getLogger(OutputStreamRenderer.class.getName()).log(Level.SEVERE, null, ioex);
			throw new utilities.exceptions.IOException(ioex);
		}
	}
	
  @Override
	public void render(String s) {
		try {
			outputStream.write(s.getBytes());
		} catch (IOException ioex) {
			Logger.getLogger(OutputStreamRenderer.class.getName()).log(Level.SEVERE, null, ioex);
			throw new utilities.exceptions.IOException(ioex);
		}
	}
	
  @Override
	public void render(Object o) {
		render(String.valueOf(o));
	}
	
}
