/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import utilities.inifile.interfaces.IIniFile;
import utilities.inifile.interfaces.IIniFileEntries;
import utilities.inifile.interfaces.IIniFileEntry;
import utilities.inifile.interfaces.IIniFileSection;
import utilities.inifile.interfaces.IIniFileSections;
import utilities.inifile.interfaces.IIniFileWriter;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileWriter implements IIniFileWriter {
  
  private OutputStream outputStream;
  private boolean closeStreamWhenDone = true;
  
  public IniFileWriter(OutputStream outputStream) {
    this.outputStream = outputStream;
  }

  @Override
  public void write(IIniFile iniFile) {
    PrintWriter printWriter = new PrintWriter(outputStream);
    
    writeSection(printWriter, iniFile.getRootSection());
    writeSections(printWriter, iniFile.getSections());
    
    try {
      outputStream.flush();
      if (closeStreamWhenDone) {
        outputStream.close();
      }
    } catch (IOException ioex) {
      throw new utilities.exceptions.IOException(ioex);
    }
  }
  
  public void setCloseStreamWhenDone(boolean value) {
    this.closeStreamWhenDone = value;
  }
  
  public boolean isCloseStreamWhenDone() {
    return closeStreamWhenDone;
  }
  
  private void writeSections(PrintWriter printWriter, IIniFileSections sections) {
    for (IIniFileSection section : sections) {
      printWriter.println();
      writeSection(printWriter, section);
    }
  }
  
  private void writeSection(PrintWriter printWriter, IIniFileSection section) {
    writeSectionName(printWriter, section.getName());
    writeSectionEntries(printWriter, section.getEntries());
  }
  
  private void writeSectionName(PrintWriter printWriter, String name) {
    printWriter.print('[');
    printWriter.print(name);
    printWriter.println(']');
  }
  
  private void writeSectionEntries(PrintWriter printWriter, IIniFileEntries entries) {
    for (IIniFileEntry entry : entries) {
      writeEntry(printWriter, entry);
    }
  }
  
  private void writeEntry(PrintWriter printWriter, IIniFileEntry entry) {
    printWriter.print(entry.getKey());
    printWriter.print('=');
    printWriter.println(entry.getValue());
  }
  
}
