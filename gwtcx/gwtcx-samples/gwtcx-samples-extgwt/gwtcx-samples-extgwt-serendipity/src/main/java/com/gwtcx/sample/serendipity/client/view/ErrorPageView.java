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

package com.gwtcx.sample.serendipity.client.view;

import com.gwtcx.sample.serendipity.client.presenter.ErrorPagePresenter;
import com.gwtcx.client.uihandlers.ErrorPageUiHandlers;
import com.gwtcx.extgwt.client.view.AbstractErrorPageView;

public class ErrorPageView extends AbstractErrorPageView<ErrorPageUiHandlers> implements
    ErrorPagePresenter.MyView {

  private final String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td style=\"font-weight:bold;\">An error has occurred.</td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>Try this action again. If the problem continues,</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>check the Serendipity forums for a solution or</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>contact your Serendipity administrator.</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td id=\"okButtonContainer\"></td>\n"
    + "  </tr>\n"
    + "</table>\n"
    + "</div>\n";

  public ErrorPageView() {
    super();
  }

  @Override
  protected String getPanelHtml() {
    return html;
  }
}
