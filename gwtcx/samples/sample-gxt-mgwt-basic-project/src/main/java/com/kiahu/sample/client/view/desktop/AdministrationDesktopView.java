/**
 * (C) Copyright 2012 Kiahu
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

package com.kiahu.sample.client.view.desktop;

import com.google.inject.Inject;
import com.gwtcx.client.uihandlers.AdministrationUiHandlers;
import com.gwtcx.extgwt.client.desktop.view.AbstractAdministrationDesktopView;
import com.kiahu.sample.client.presenter.AdministrationPresenter;

public class AdministrationDesktopView extends AbstractAdministrationDesktopView<AdministrationUiHandlers>
    implements AdministrationPresenter.MyView {

  @Inject
  public AdministrationDesktopView() {
    super(ADMINISTRATION_FILENAME);
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }
}