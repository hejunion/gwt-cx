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

package com.kiahu.sample.client.view.tablet.animations;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.kiahu.sample.client.presenter.tablet.animations.SlideUpPresenter;

public class SlideUpView extends AbstractAnimationView implements SlideUpPresenter.MyView {

  @Inject
  public SlideUpView() {
    super();

    Log.debug("SlideUpView()");
  }
}