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

package com.gwtcx.shared.dto;

import java.io.Serializable;

public class EntityDto implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;

  public EntityDto() {
    this.id = "-1";
  }

  public EntityDto(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  // http://en.wikipedia.org/wiki/Method_chaining
  public EntityDto setId(String id) {
    this.id = id;
    return this;
  }
}
