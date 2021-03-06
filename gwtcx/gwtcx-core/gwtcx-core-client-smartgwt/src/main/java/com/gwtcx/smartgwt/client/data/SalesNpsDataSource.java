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

package com.gwtcx.smartgwt.client.data;

import com.google.gwt.core.client.GWT;
import com.gwtcx.client.NameTokens;
import com.gwtcx.smartgwt.client.data.NavigationPaneSectionDataSource;

public class SalesNpsDataSource extends NavigationPaneSectionDataSource {

  // the name of the default ListGrid item to select
  // see NavigationPaneSectionListGrid -> onDataArrived()
  // see MainPageView -> initNavigationPane()
  public static final String DEFAULT_RECORD_NAME = NameTokens.activities;

  protected static final String DATA_SOURCE = "SalesNps";
  // private static final String URL_PREFIX = "datasource/data/SalesNps";
  protected static final String URL_PREFIX = GWT.getModuleName() + "/gwtcx/smartgwt/" + "datasource/data/SalesNps";
  protected static final String URL_SUFFIX = ".xml";

  private static SalesNpsDataSource instance;

  public static SalesNpsDataSource getInstance() {
    if (instance == null) {
      instance = new SalesNpsDataSource(DATA_SOURCE);
    }

    return instance;
  }

  public SalesNpsDataSource(String id) {
    super(id);

    setDataURL(URL_PREFIX, URL_SUFFIX);
  }
}
