/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.smartgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.smartgwt.client.data.NavigationPaneSectionDataSource;
import com.gwtcx.smartgwt.client.widgets.grid.NavigationPaneSectionListGrid;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.SectionStackSection;

/**
 * NavigationPaneSection
 */
public class NavigationPaneSection extends SectionStackSection {

  private NavigationPaneSectionListGrid listGrid;

  public NavigationPaneSection(String sectionName, DataSource dataSource) {
    super(sectionName);

    this.setID(sectionName);

    listGrid = new NavigationPaneSectionListGrid(dataSource);

    this.addItem(listGrid);
    this.setExpanded(true);
  }

  public ListGrid getListGrid() {
    return listGrid;
  }

  public void selectRecord(int record) {
    listGrid.selectRecord(record);
  }

  public int getRecord(String name) {
    int result = -1;

    // Log.debug("init getRecord() - " + name);

    ListGridRecord[] records = listGrid.getRecords();
    ListGridRecord record = null;
    String recordName = "";

    if (records.length == 0) {
      // see NavigationPaneSectionListGrid -> onDataArrived()
      Log.info("No data has arrived.");
    }

    /*

    if (Log.isDebugEnabled()) {
      if (records.length == 0) {
        // see NavigationPaneSectionListGrid -> onDataArrived()
        Log.debug("No data has arrived...");
      }
    }

    */

    for (int i = 0; i < records.length; i++) {

      record = listGrid.getRecord(i);
      // as per NavigationPaneSectionListGrid
      recordName = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);

      if (name.contentEquals(recordName)) {
        // logger.log(Level.INFO, "name.contentEquals(recordName)");
        result = i;
        break;
      }
    }

    return result;
  }

  public String getSelectedRecord() {
    String name = "";

    ListGridRecord record = listGrid.getSelectedRecord();

    if (record != null) {
      // get the name of the first selected record e.g. "Activities"
      name = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);
    } else {
      Log.debug("getSelectedRecord() - No selected record in ListGrid");

      record = listGrid.getRecord(0);

      // see NavigationPaneSectionListGrid - DataArrivedHandler()
      if (record != null) {
        // get the name of the first record in the ListGrid e.g. "Activities"
        name = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);
      }
    }

    Log.debug("getSelectedRecord() - " + name);

    return name;
  }

  /*

  public String getSelectedRecord() {
    String name = "";

    ListGridRecord[] records = listGrid.getSelection();

    if (records.length != 0) {
      // get the name of the first selected record e.g. "Activities"
      name = records[0].getAttributeAsString(NavigationPaneSectionDataSource.NAME);
    } else {
      // logger.log(Level.INFO, "getSelectedRecord() - No selected record in ListGrid");

      ListGridRecord record = listGrid.getRecord(0);

      // see NavigationPaneSectionListGrid - DataArrivedHandler()
      if (record != null) {
        // get the name of the first record in the ListGrid e.g. "Activities"
        name = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);
      }
    }

    // logger.log(Level.INFO, "getSelectedRecord() - " + name);

    return name;
  }

  */

  public void selectRecord(String name) {
    // logger.log(Level.INFO, "selectRecord(name) - " + name);

    ListGridRecord[] records = listGrid.getRecords();
    ListGridRecord record = null;
    String recordName = "";

    for (int i = 0; i < records.length; i++) {

      record = listGrid.getRecord(i);
      recordName = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);

      if (name.contentEquals(recordName)) {
        // logger.log(Level.INFO, "name.contentEquals(recordName)");
        listGrid.deselectAllRecords();
        listGrid.selectRecord(i);
        break;
      }
    }
  }

  public void addRecordClickHandler(RecordClickHandler clickHandler) {
      listGrid.addRecordClickHandler(clickHandler);
  }
}

