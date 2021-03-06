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

package com.gwtcx.extgwt.client.desktop.view.contact.tab.section;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;

public class ContactPreferencesSection extends EntitySection<ContactRepresentation> {

  // FIELD_LABEL, HTML_DATA
  private String[][] toggleGroupTemplate = {
    {I18nUtil.getConstant().emailLabel(), ".email"},
    {I18nUtil.getConstant().phoneLabel(), ".phone"},
    {I18nUtil.getConstant().faxLabel(), ".fax"},
    {I18nUtil.getConstant().mailLabel(), ".mail"}
  };

  public ContactPreferencesSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("PersonalInformationSection()");

    setToggleGroupTemplate(toggleGroupTemplate);

    createToggleGroups();
  }

  @Override
  public void setFields(ContactRepresentation dto) {

  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }
}

/*


    Log.debug("createRadios()");

    emailAllow = new Radio();
    emailAllow.setBoxLabel(I18nUtil.getConstant().allowLabel());
    emailDoNotAllow = new Radio();
    emailDoNotAllow.setBoxLabel(I18nUtil.getConstant().doNotAllowLabel());

    emailPanel = new HorizontalPanel();
    emailPanel.add(emailAllow);
    emailPanel.add(emailDoNotAllow);

    getPanel().add(new FieldLabel(emailPanel, I18nUtil.getConstant().emailLabel()), new HtmlData(".email"));

    emailToggleGroup = new ToggleGroup();
    emailToggleGroup.add(emailAllow);
    emailToggleGroup.add(emailDoNotAllow);

    emailDoNotAllow.setValue(true);
    Radio radio = (Radio) emailToggleGroup.getValue();

    if (radio != null) {
      Log.debug("Email:" + radio.getBoxLabel());
    }









  protected Radio emailAllow;
  protected Radio emailDoNotAllow;
  protected HorizontalPanel emailPanel;
  protected ToggleGroup emailToggleGroup;

        Radio radio = (Radio)group.getValue();
        Info.display("Color Changed", "You selected " + radio.getBoxLabel());

            // we can set name on radios or use toggle group
    ToggleGroup toggle = new ToggleGroup();
    toggle.add(radio);
    toggle.add(radio2);
    toggle.addValueChangeHandler(new ValueChangeHandler<HasValue<Boolean>>() {

      @Override
      public void onValueChange(ValueChangeEvent<HasValue<Boolean>> event) {
        ToggleGroup group = (ToggleGroup)event.getSource();
        Radio radio = (Radio)group.getValue();
        Info.display("Color Changed", "You selected " + radio.getBoxLabel());
      }
    });

*/
