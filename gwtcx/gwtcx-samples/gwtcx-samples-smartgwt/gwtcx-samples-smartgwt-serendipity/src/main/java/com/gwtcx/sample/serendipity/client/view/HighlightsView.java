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

import com.google.inject.Inject;
import com.gwtcx.sample.serendipity.client.presenter.HighlightsPresenter;
import com.gwtcx.client.uihandlers.HighlightsUiHandlers;
import com.gwtcx.smartgwt.client.view.AbstractHighlightsView;

public class HighlightsView extends AbstractHighlightsView<HighlightsUiHandlers> implements
    HighlightsPresenter.MyView {

  @Inject
  public HighlightsView() {
    super();
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }
}

