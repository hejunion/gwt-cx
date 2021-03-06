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

package com.kiahu.sample.shared.restlet;

import org.restlet.resource.Get;
// import org.restlet.resource.Options;

import com.gwtcx.shared.dto.ContactsRepresentation;

public interface ContactsResource {

  @Get
  public ContactsRepresentation retreive();

  // @Get
  // ContactRepresentation getContact();

  // @Options
  // public String description();

  // @Post
  // public void add(ContactRepresentation contact);
}
