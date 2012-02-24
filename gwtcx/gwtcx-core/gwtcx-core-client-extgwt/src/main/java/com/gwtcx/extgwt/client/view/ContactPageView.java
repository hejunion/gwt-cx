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

package com.gwtcx.extgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.presenter.ContactPagePresenter;
import com.gwtcx.client.resources.ToolBarIcons;
import com.gwtcx.client.uihandlers.ContactPageUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.gwtcx.extgwt.client.widgets.ContactDetailsNavigationPaneSection;
import com.gwtcx.extgwt.client.widgets.Masthead;
import com.gwtcx.extgwt.client.widgets.NavigationPaneSection;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.ContentPanel.ContentPanelAppearance;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;

public class ContactPageView extends AbstractContactPageView<ContactPageUiHandlers> implements
    ContactPagePresenter.MyView {

  public interface ContactPageUiBinder extends UiBinder<Viewport, ContactPageView> { }

  private static ContactPageUiBinder uiBinder = GWT.create(ContactPageUiBinder.class);

  protected NavigationPaneSection detailsSection;

  @Inject
  public ContactPageView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Masthead masthead) {
    super(toolBar, masthead);

    Log.debug("ContactPageView()");

    // expand the first Navigation Pane section
    getNavigationPane().setWidget(getNavigationPane().getWidget(0));
  }

  @Override
  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    setViewport(uiBinder.createAndBindUi(this));
  }

  @UiFactory
  public ContentPanel createContentPanel(ContentPanelAppearance appearance) {
    return new ContentPanel(appearance);
  }

  @Override
  public void setInSlot(Object slot, Widget content) {

    Log.debug("setInSlot() - getCenterLayoutContainer().add(content)");

    if (content != null) {

      Log.debug("content: " + content.getClass().getName()) ;

      getCenterPanel().add(content);

      if (content instanceof com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) {

        Log.debug("panel.onResize()") ;

        ((com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) content).onResize();
      }
    }
  }

  @Override
  public void removeFromSlot(Object slot, Widget content) {
    super.removeFromSlot(slot, content);

    Log.debug("removeFromSlot()");
  }

  @Override
  protected void initToolBar() {

    getWestPanel().getHeader().hide();
    // getWestPanel().getHeader().setVisible(false);
    // getCenterPanel().getHeader().hide();

    ToolTipConfig config = getToolBar().createToolTipConfig(I18nUtil.getConstant().saveButtonTooltip(), "Save the new Contact");

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.save(), null, config, new SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onSaveButtonClicked();
        }
      }
    });

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.saveAndClose(), null, null, new SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {
        if (getUiHandlers() != null) {
          getUiHandlers().onSaveAndCloseButtonClicked();
        }
      }
    });

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.printPreview(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.sendEmail(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.attach(), null, null);
    getToolBar().addTextButton(ToolBarIcons.INSTANCE.reports(), null, null);

    getToolBar().addSeparator();

    getToolBar().addTextButton(ToolBarIcons.INSTANCE.help(), null, null);

    getToolBar().addFill();
  }

  @Override
  protected void initNavigationPane() {

    Log.debug("initNavigationPane()");

    detailsSection = getNavigationPane().addSection(new ContactDetailsNavigationPaneSection()) ;
    detailsSection.addRowClickHandler(new RowClickHandler() {
      @Override
      public void onRowClick(RowClickEvent event) {
        NavigationPaneSectionModel model = (NavigationPaneSectionModel) detailsSection.getGrid().getStore().get(event.getRowIndex());
        navigationPaneSectionClicked(model.getName());
      }
    });
  }

  protected void navigationPaneSectionClicked(String place) {
    if (getUiHandlers() != null) {
      getUiHandlers().onNavigationPaneSectionClicked(place);
    }
  }
}