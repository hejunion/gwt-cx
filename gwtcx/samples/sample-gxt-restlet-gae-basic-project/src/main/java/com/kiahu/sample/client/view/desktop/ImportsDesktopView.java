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

import com.gwtcx.client.uihandlers.ImportsUiHandlers;
import com.gwtcx.extgwt.client.desktop.view.PlaceholderView;
import com.kiahu.sample.client.presenter.ImportsPresenter;

/**
 * ImportsView
 */
public class ImportsDesktopView extends PlaceholderView implements ImportsPresenter.MyView {

  private final String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td style=\"font-weight:bold;\">Placeholder Imports view</td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "</table>\n"
    + "</div>\n";

  // @Override
  public void setUiHandlers(ImportsUiHandlers uiHandlers) {
  }

  @Override
  protected String getPanelHtml() {
    return html;
  }
}
