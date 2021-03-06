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

package com.kiahu.sample.client.view.tablet.ui;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.ProgressIndicator;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.ProgressIndicatorPresenter;
import com.kiahu.sample.client.util.ChromeWorkaround;

public class ProgressIndicatorView extends AbstractUiView implements ProgressIndicatorPresenter.MyView {

  @Inject
  public ProgressIndicatorView() {
    super();

    Log.debug("ProgressIndicatorView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    FlowPanel content = new FlowPanel();
	content.getElement().getStyle().setMarginTop(20, Unit.PX);

	ProgressIndicator progressIndicator = new ProgressIndicator();
	progressIndicator.getElement().setAttribute("style", "margin:auto; margin-top: 50px");

	content.add(progressIndicator);

	HTML html = new HTML("CSS3 animations make it possible to animate transitions from one CSS style configuration to another.");
	html.getElement().setAttribute("style", "text-align: center; margin-top: 20px;");
	content.add(html);

	scrollPanel.setWidget(content);

	ChromeWorkaround.maybeUpdateScroller(scrollPanel);

    headerPanel.setCenter(NameTokens.progressIndicator);
  }
}