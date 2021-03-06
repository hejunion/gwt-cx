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

public class SettingsCaDataSource extends ContextAreaDataSource {

  protected static final String DATA_SOURCE = "SettingsCa";
  // protected static final String URL_PREFIX = "datasource/data/SettingsCa";
  protected static final String URL_PREFIX = GWT.getModuleName() + "/gwtcx/smartgwt/" + "datasource/data/SettingsCa";
  protected static final String URL_SUFFIX = ".xml";

  private static SettingsCaDataSource instance = null;

  public static SettingsCaDataSource getInstance() {
    if (instance == null) {
      instance = new SettingsCaDataSource(DATA_SOURCE);
    }

    return instance;
  }

  public SettingsCaDataSource(String id) {
    super(id);

    setDataURL(URL_PREFIX, URL_SUFFIX);
  }
}
