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

package com.gwtcx.extgwt.client.data;

import com.gwtcx.shared.dto.ContactsDto;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;

public class ContactsDtoListStore extends ListStore<ContactsDto> {

  public static ModelKeyProvider<ContactsDto> KP = new ModelKeyProvider<ContactsDto>() {
    @Override
    public String getKey(ContactsDto item) {
      return item.getId();
    }
  };

  public ContactsDtoListStore() {
    super(KP);
  }
}
