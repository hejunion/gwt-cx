/**
 * (C) Copyright 2010-2013 Kiahu
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

package com.gwtcx.extgwt.client.desktop.view.contact.tab;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabPanel;

public class InformationGeneralTab extends AbstractContactTab {

  private String[][] fieldSets = {
    {"General Information"},
    {"Address Information"}
  };

  public InformationGeneralTab(TabPanel tabPanel) {
    super(tabPanel);

    Log.debug("InformationGeneralTab(TabPanel tabPanel)");

    setFieldSets(fieldSets);

    createFields(I18nUtil.getConstant().generalTabLabel(), generalTabIcon);
  }

  // TODO: don't use fixed array indices

  public EntitySection<ContactRepresentation> getEntitySection(Section section) {

    EntitySection<ContactRepresentation> result = null;

    if (getFieldSets() == null) {
      Log.error("You must call setFieldSets(String[][] fields) in the constructor of your derived class");
      return result;
    }

    Log.debug("getEntitySection()");

    switch (section) {

      case GENERAL_INFORMATION:

        Log.debug("case GENERAL_INFORMATION:");

        result = getEntitySections()[0]; break;

      case ADDRESS_INFORMATION: result = getEntitySections()[1];; break;

      default:
        break;
    }

    return result;
  }
}