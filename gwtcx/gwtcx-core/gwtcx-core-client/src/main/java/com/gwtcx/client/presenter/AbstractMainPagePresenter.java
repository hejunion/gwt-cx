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

package com.gwtcx.client.presenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public abstract class AbstractMainPagePresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> implements
    MainPageUiHandlers {

  private final PlaceManager placeManager;

  @Inject
  public AbstractMainPagePresenter(EventBus eventBus, V view, Proxy_ proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy);

    this.placeManager = placeManager;
  }

  @Override
  protected void revealInParent() {
    // RevealRootContentEvent.fire(this, this);
    RevealRootLayoutContentEvent.fire(this, this);
  }

  protected void navigationPaneClicked(String place) {
    if (place.length() != 0) {
      PlaceRequest placeRequest = new PlaceRequest(place);
      getPlaceManager().revealPlace(placeRequest);
    }
  }

  public void onNewActivityClicked(String place) {
    AbstractActivitiesPresenter.newActivity();
  }

  public void onNewRecordClicked(String place) {
    AbstractAccountsPresenter.newAccount();
  }

  public void onGoToMenuItemClicked(String place) {
    navigationPaneClicked(place);
  }

  public void onNavigationPaneSectionHeaderClicked(String place) {
    navigationPaneClicked(place);
  }

  public void onNavigationPaneSectionClicked(String place) {
    navigationPaneClicked(place);
  }

  public PlaceManager getPlaceManager() {
    return placeManager;
  }
}
