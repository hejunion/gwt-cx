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

package com.kiahu.sample.client.place;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;


public class BasicProjectPlaceManager extends PlaceManagerImpl {

  private final PlaceRequest defaultPlaceRequest;

  @Inject
  public BasicProjectPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter,
      @DefaultPlace String defaultPlaceNameToken) {
    super(eventBus, tokenFormatter);

    this.defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
  }

  @Override
  public void revealDefaultPlace() {
    revealPlace(defaultPlaceRequest);
  }

  /*

  @Override
  public void revealUnauthorizedPlace(String unauthorizedHistoryToken) {
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.signInPage);
    placeRequest = placeRequest.with("redirect", unauthorizedHistoryToken);
    revealPlace(placeRequest);
  }

  */

  @Override
  public void revealErrorPlace(String invalidHistoryToken) {
    PlaceRequest placeRequest = new PlaceRequest(NameTokens.errorPage);
    revealPlace(placeRequest);
  }
}
