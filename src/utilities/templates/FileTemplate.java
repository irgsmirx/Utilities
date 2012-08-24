/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class FileTemplate extends AbstractTemplate {
  
  private File template;
  
  public FileTemplate(File file) {
    super();
    this.template = file;
  }
  
  public FileTemplate(File file, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
    super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
    this.template = file;
  }
  
  public FileTemplate(String filePath) {
    super();
    this.template = new File(filePath);
  }

  public FileTemplate(String filePath, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
    super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
    this.template = new File(filePath);
  }

  
  private InputStreamTemplate createInputStreamTemplate() {
    try {
      FileInputStream fileInputStream = new FileInputStream(template);
      InputStreamTemplate inputStreamTemplate = new InputStreamTemplate(fileInputStream);
      return inputStreamTemplate;
    } catch (FileNotFoundException ex) {
      Logger.getLogger(FileTemplate.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException(ex);
    }
  }
  
  @Override
  public void renderTo(OutputStream outputStream) {
    createInputStreamTemplate().renderTo(outputStream);
  }

  @Override
  public String render() {
    return createInputStreamTemplate().render();
  }
  
  
  
}
