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

package com.gwtcx.sample.basic.client.gin;

import com.gwtcx.sample.basic.client.presenter.MainPagePresenter;
import com.gwtcx.sample.basic.client.view.mobile.MainPageMobileView;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MobileGinModule  extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Presenters
    //

    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageMobileView.class, MainPagePresenter.MyProxy.class);
  }
}
