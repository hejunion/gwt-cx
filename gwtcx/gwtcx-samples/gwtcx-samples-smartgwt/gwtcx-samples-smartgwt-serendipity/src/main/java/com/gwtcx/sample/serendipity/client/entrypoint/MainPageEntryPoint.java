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

package com.gwtcx.sample.serendipity.client.entrypoint;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.NameTokens;

public class MainPageEntryPoint extends MultiPageEntryPoint {

  @Override
  protected void revealCurrentPlace(String page) {

    if (page.equals(NameTokens.mainPage)) {
      getSerendipityGinjector().getPlaceManager().revealCurrentPlace();
    } else {
      Log.debug("Page name token: " + page);
    }
  }
}

/*

} else if (page.equals(NameTokens.accountPage)) {

  String activity = Window.Location.getParameter(AccountsRecord.ACTIVITY);
  String accountId= Window.Location.getParameter(AccountsRecord.ACCOUNT_ID);

  placeRequest = new PlaceRequest(NameTokens.accountPage);
  placeRequest = placeRequest.with(AccountsRecord.ACTIVITY, activity).with(AccountsRecord.ACCOUNT_ID, accountId);
  ginjector.getPlaceManager().revealPlace(placeRequest);
}

*/