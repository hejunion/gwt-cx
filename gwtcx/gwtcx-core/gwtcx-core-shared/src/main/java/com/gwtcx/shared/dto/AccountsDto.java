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

package com.gwtcx.shared.dto;

import java.io.Serializable;

public class AccountsDto implements Serializable {

  private static final long serialVersionUID = 7749630501976551263L;

  private String id;
  private String accountName;
  // private String accountNumber;
  private String mainPhone;
  private String location;  // private String city;
  private String primaryContact;
  private String emailPrimaryContact;

  public AccountsDto() {
    this.id = "-1";
  }

  public AccountsDto(String id) {
    this.id = id;
  }

  public AccountsDto(String id, String accountName, String mainPhone,
      String location, String primaryContact, String emailPrimaryContact) {

    this.id = id;
    this.accountName = accountName;
    this.mainPhone = mainPhone;
    this.location = location;
    this.primaryContact = primaryContact;
    this.emailPrimaryContact = emailPrimaryContact;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  // public void setAccountId(String accountId) {
  //   this.accountId = Long.parseLong(accountId);
  // }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getMainPhone() {
    return mainPhone;
  }

  public void setMainPhone(String mainPhone) {
    this.mainPhone = mainPhone;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPrimaryContact() {
    return primaryContact;
  }

  public void setPrimaryContact(String primaryContact) {
    this.primaryContact = primaryContact;
  }

  public String getEmailPrimaryContact() {
    return emailPrimaryContact;
  }

  public void setEmailPrimaryContact(String emailPrimaryContact) {
    this.emailPrimaryContact = emailPrimaryContact;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AccountsDto [accountId=");
    builder.append(id);
    builder.append(", accountName=");
    builder.append(accountName);
    builder.append(", mainPhone=");
    builder.append(mainPhone);
    builder.append(", location=");
    builder.append(location);
    builder.append(", primaryContact=");
    builder.append(primaryContact);
    builder.append(", emailPrimaryContact=");
    builder.append(emailPrimaryContact);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof AccountsDto))
      return false;
    AccountsDto other = (AccountsDto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (accountName == null) {
      if (other.accountName != null)
        return false;
    } else if (!accountName.equals(other.accountName))
      return false;
    if (emailPrimaryContact == null) {
      if (other.emailPrimaryContact != null)
        return false;
    } else if (!emailPrimaryContact.equals(other.emailPrimaryContact))
      return false;
    if (location == null) {
      if (other.location != null)
        return false;
    } else if (!location.equals(other.location))
      return false;
    if (mainPhone == null) {
      if (other.mainPhone != null)
        return false;
    } else if (!mainPhone.equals(other.mainPhone))
      return false;
    if (primaryContact == null) {
      if (other.primaryContact != null)
        return false;
    } else if (!primaryContact.equals(other.primaryContact))
      return false;
    return true;
  }
}