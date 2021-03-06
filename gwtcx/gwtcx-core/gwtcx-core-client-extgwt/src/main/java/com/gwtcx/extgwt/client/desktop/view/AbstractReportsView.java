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

package com.gwtcx.extgwt.client.desktop.view;

import java.util.List;

import com.google.inject.Inject;
import com.gwtcx.client.resources.ToolBarIcons;
import com.gwtcx.client.uihandlers.ReportsUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountsDto;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;

/**
 * AbstractReportsView
 */
public abstract class AbstractReportsView<C extends UiHandlers> extends AbstractPagingView<C> {

  // protected String recordId;

  @Inject
  public AbstractReportsView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Grid<?> grid) {
    super(toolBar, grid);

    // recordId = new String("-1");
  }

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();

    // initialise the ToolBar and register its handlers
    initToolBar();

    // initialise the StatusBar and register its handlers
    initStatusBar();
  }

  public void setResultSet(List<AccountsDto> resultSet) {
    // resultSet == null when there are no items in the table
    // if (resultSet != null) {
    //   assert getGrid() instanceof AccountsContextAreaListGrid;
    //   ((AccountsContextAreaGrid) getGrid()).setResultSet(resultSet);
    // }
  }

  @Override
  protected void initToolBar() {

    ToolTipConfig config = getToolBar().createToolTipConfig(I18nUtil.getConstant().newButton(), "Create a new Report");

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.newAccount(), I18nUtil.getConstant().newButton(), config, new SelectHandler() {
    @Override
      public void onSelect(SelectEvent event) {
        if (getUiHandlers() != null) {
          assert getUiHandlers() instanceof ReportsUiHandlers;
          ((ReportsUiHandlers) getUiHandlers()).onNewButtonClicked();
        }
      }
    });

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.printPreview(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.export(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.assign(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.delete(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.refresh(), null, null);

    getToolBar().addFill();
  }

  @Override
  protected void initStatusBar() {

  }
}

// Info.display("Click", ((TextButton) event.getSource()).getText() + " clicked");

