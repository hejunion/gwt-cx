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

package com.gwtcx.smartgwt.client.widgets.toolbar;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class ToolBar extends HLayout {

  public static final String TOOLBAR_STYLE_NAME = "gwtcx-ToolBar";
  public static final String TOOLSTRIP_STYLE_NAME = "gwtcx-ToolStrip";

  public static final String LOGO_IMAGE = "toolbar/logo.png";

  public static final String NEW_ACTIVITY_BUTTON = "toolbar/newactivity.png";
  public static final String NEW_IMPORT_BUTTON = "toolbar/newimport.png";
  public static final String NEW_ACCOUNT_BUTTON = "toolbar/newaccount.png";
  public static final String NEW_CONTACT_BUTTON = "toolbar/newcontact.png";
  public static final String NEW_QUEUE_BUTTON = "toolbar/newqueue.png";
  public static final String NEW_REPORT_BUTTON = "toolbar/newreport.png";

  public static final String PRINT_PREVIEW_BUTTON = "toolbar/printpreview.png";
  public static final String EXPORT_BUTTON = "toolbar/export.png";
  public static final String MAIL_MERGE_BUTTON = "toolbar/mailmerge.png";
  public static final String ASSIGN_BUTTON = "toolbar/assign.png";
  public static final String DELETE_BUTTON = "toolbar/delete.png";
  public static final String EMAIL_BUTTON = "toolbar/sendemail.png";
  public static final String ATTACH_BUTTON = "toolbar/attach.png";
  public static final String REFRESH_BUTTON = "toolbar/refresh.png";

  public static final String WORKFLOW_BUTTON = "toolbar/workflow.png";
  public static final String REPORTS_BUTTON = "toolbar/reports.png";

  public static final String SAVE_BUTTON = "toolbar/save.png";
  public static final String SAVE_AND_CLOSE_BUTTON = "toolbar/saveandclose.png";
  public static final String HELP_BUTTON = "toolbar/help.png";

  public static final int TOOLBAR_HEIGHT = 25;
  // public static final String TOOLBAR_HEIGHT = "25px";

  private static final String TOOLSTRIP_WIDTH = "*";

  protected ToolStrip toolStrip;

  public ToolBar() {
    super();

    init(TOOLBAR_STYLE_NAME, TOOLSTRIP_STYLE_NAME);
  }

  public ToolBar(String styleName, String toolStripStyleName) {
    super();

    init(styleName, toolStripStyleName);
  }

  private void init(String styleName, String toolStripStyleName) {

    // initialise the ToolBar layout container
    this.setStyleName(styleName);
    this.setHeight(TOOLBAR_HEIGHT);

    // initialise the ToolBar's ToolStrip
    toolStrip = new ToolStrip();
    toolStrip.setStyleName(toolStripStyleName);
    toolStrip.setHeight(TOOLBAR_HEIGHT);
    toolStrip.setWidth(TOOLSTRIP_WIDTH);

    // add the ToolStrip to the ToolBar's layout container
    this.addMember(toolStrip);
  }

  public ToolStripButton addButton(String title, ClickHandler clickHandler) {
    ToolStripButton button = new ToolStripButton();
    button.setTitle(title);

    if (clickHandler != null)
      button.addClickHandler(clickHandler);

    toolStrip.addButton(button);

    return button;
  }

  public ToolStripButton addButton(String icon, String tooltip, ClickHandler clickHandler) {
    ToolStripButton button = new ToolStripButton();
    button.setIcon(icon);
    button.setTooltip(tooltip);

    if (clickHandler != null)
      button.addClickHandler(clickHandler);

    toolStrip.addButton(button);

    return button;
  }

  public ToolStripButton addButton(String icon, String title, String tooltip, ClickHandler clickHandler) {
    ToolStripButton button = new ToolStripButton();
    button.setIcon(icon);
    button.setTitle(title);
    button.setTooltip(tooltip);

    if (clickHandler != null)
      button.addClickHandler(clickHandler);

    toolStrip.addButton(button);

    return button;
  }

  public Label addLabel(String contents) {
    Label label = new Label();
    label.setContents(contents);

    toolStrip.addMember(label);

    return label;
  }

  public void addSeparator() {
    toolStrip.addSeparator();
  }

  public ToolStrip getToolStrip() {
    return toolStrip;
  }
}
