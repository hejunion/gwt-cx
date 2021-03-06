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

package com.gwtcx.server.domain;

public class EntityTokens {

  // Delimited identifiers may include additional characters from the character
  // set implied by the locale setting of the database. Letters in delimited
  // identifiers are case sensitive.
  //
  // In most databases, delimited identifiers are enclosed in double quotes.
  //
  // Note: Database object names specified in annotations are case-insensitive
  // if the database in use is case-insensitive.

  //
  // Account table
  //
  public static final String ACCOUNT_TABLE = "\"ACCOUNT\"";
  public static final String ACCOUNT_TABLE_DISCRIMINATOR_VALUE = "A";
  // Account column names
  public static final String ACCOUNT_ID_COLUMN = "\"ACCOUNT_ID\"";
  public static final String ACCOUNT_NAME_COLUMN = "\"ACCOUNT_NAME\"";
  public static final String ACCOUNT_NUMBER_COLUMN = "\"ACCOUNT_NUMBER\"";
  public static final String PARENT_ACCOUNT_COLUMN = "\"PARENT_ACCOUNT\"";

  public static final String PRIMARY_CONTACT_COLUMN = "\"PRIMARY_CONTACT\"";
  public static final String EMAIL_PRIMARY_CONTACT_COLUMN = "\"EMAIL_PRIMARY_CONTACT\"";

  public static final String MAIN_PHONE_COLUMN = "\"MAIN_PHONE\"";
  public static final String OTHER_PHONE_COLUMN = "\"OTHER_PHONE\"";
  public static final String FAX_COLUMN = "\"FAX\"";
  public static final String WEB_SITE_COLUMN = "\"WEB_SITE\"";
  // Account column lengths
  public static final int ACCOUNT_NAME_COLUMN_LENGTH = 100;
  public static final int ACCOUNT_NUMBER_COLUMN_LENGTH = 50;
  public static final int PARENT_ACCOUNT_COLUMN_LENGTH = 100;

  public static final int PRIMARY_CONTACT_COLUMN_LENGTH = 100;
  public static final int EMAIL_PRIMARY_CONTACT_COLUMN_LENGTH = 50;

  public static final int MAIN_PHONE_COLUMN_LENGTH = 50;
  public static final int OTHER_PHONE_COLUMN_LENGTH = 50;
  public static final int FAX_COLUMN_LENGTH = 50;
  public static final int WEB_SITE_COLUMN_LENGTH = 50;

  //
  // Address table
  //
  public static final String ADDRESS_TABLE = "\"ADDRESS\"";
  // Address column names
  public static final String ADDRESS_ID_COLUMN = "\"ADDRESS_ID\"";
  public static final String ADDRESS_NAME_COLUMN = "\"ADDRESS_NAME\"";
  public static final String ADDRESS_LINE_1_COLUMN = "\"ADDRESS_LINE_1\"";
  public static final String ADDRESS_LINE_2_COLUMN = "\"ADDRESS_LINE_2\"";
  public static final String ADDRESS_LINE_3_COLUMN = "\"ADDRESS_LINE_3\"";
  public static final String CITY_COLUMN = "\"CITY\"";
  public static final String STATE_COLUMN = "\"STATE\"";
  public static final String POSTAL_CODE_COLUMN = "\"POSTAL_CODE\"";
  public static final String COUNTRY_COLUMN = "\"COUNTRY\"";
  public static final String ADDRESS_TYPE_COLUMN = "\"ADDRESS_TYPE\"";
  // Account column lengths
  public static final int ADDRESS_NAME_COLUMN_LENGTH = 100;
  public static final int ADDRESS_LINE_COLUMN_LENGTH = 100;
  public static final int CITY_COLUMN_LENGTH = 50;
  public static final int STATE_COLUMN_LENGTH = 50;
  public static final int POSTAL_CODE_COLUMN_LENGTH = 10;
  public static final int COUNTRY_COLUMN_LENGTH = 50;
  public static final int ADDRESS_TYPE_COLUMN_LENGTH = 50;

  //
  // Account Address join table name
  //
  public static final String ACCOUNT_ADDRESS_JOIN_TABLE = "\"ACCOUNT_ADDRESS\"";

  //
  // BaseEntity is a MappedSuperclass (e.g. no table name)
  //
  // BaseEntity column names
  public static final String VERSION_COLUMN = "\"VERSION\"";
  public static final String CREATED_BY_COLUMN = "\"CREATED_BY\"";
  public static final String CREATED_TIMESTAMP_COLUMN = "\"CREATED_TIMESTAMP\"";
  public static final String UPDATED_BY_COLUMN = "\"UPDATED_BY\"";
  public static final String UPDATED_TIMESTAMP_COLUMN = "\"UPDATED_BY_TIMESTAMP\"";
  // BaseEntity column lengths
  public static final int CREATED_BY_COLUMN_LENGTH = 50;
  public static final int UPDATED_BY_COLUMN_LENGTH = 50;
  // BaseEntity column nullable (default is true)
  public static final boolean VERSION_COLUMN_NULLABLE = false;
  public static final boolean CREATED_BY_COLUMN_NULLABLE = false;
  public static final boolean CREATED_TIMESTAMP_COLUMN_NULLABLE = false;
  public static final boolean UPDATED_BY_COLUMN_NULLABLE = false;
  public static final boolean UPDATED_TIMESTAMP_COLUMN_NULLABLE = false;

  //
  // Contact table
  //
  public static final String CONTACT_TABLE = "\"CONTACT\"";
  public static final String CONTACT_TABLE_DISCRIMINATOR_VALUE = "C";
  // Contact column names
  public static final String CONTACT_ID_COLUMN = "\"CONTACT_ID\"";
  public static final String GIVEN_NAME_COLUMN = "\"GIVEN_NAME\"";
  public static final String MIDDLE_NAME_COLUMN = "\"MIDDLE_NAME\"";
  public static final String FAMILY_NAME_COLUMN = "\"FAMILY_NAME\"";
  public static final String SALUTATION_COLUMN = "\"SALUTATION\"";
  public static final String CORRESPONDENCE_COLUMN = "\"CORRESPONDENCE\"";
  public static final String JOB_TITLE_COLUMN = "\"JOB_TITLE\"";
  public static final String OCCUPATION_COLUMN = "\"OCCUPATION\"";

  public static final String BUSINESS_PHONE_COLUMN = "\"BUSINESS_PHONE\"";
  // public static final String FAX_COLUMN = "\"FAX\"";
  public static final String MOBILE_PHONE_COLUMN = "\"MOBILE_PHONE\"";
  public static final String HOME_PHONE_COLUMN = "\"HOME_PHONE\"";
  public static final String EMAIL_COLUMN = "\"EMAIL\"";

  // Contact column lengths
  public static final int GIVEN_NAME_COLUMN_LENGTH = 50;
  public static final int MIDDLE_NAME_COLUMN_LENGTH = 50;
  public static final int FAMILY_NAME_COLUMN_LENGTH = 50;
  public static final int SALUTATION_COLUMN_LENGTH = 50;
  public static final int CORRESPONDENCE_COLUMN_LENGTH = 100;
  public static final int JOB_TITLE_COLUMN_LENGTH = 100;
  public static final int OCCUPATION_COLUMN_LENGTH = 100;

  public static final int BUSINESS_PHONE_COLUMN_LENGTH = 50;
  public static final int MOBILE_PHONE_COLUMN_LENGTH = 50;
  public static final int HOME_PHONE_COLUMN_LENGTH = 50;
  public static final int EMAIL_COLUMN_LENGTH = 50;

  //
  // Party table
  //
  public static final String PARTY_TABLE = "\"PARTY\"";
  public static final String PARTY_TABLE_DISCRIMINATOR_VALUE = "P";
  // Party column names
  public static final String PARTY_ID_COLUMN = "\"PARTY_ID\"";
  public static final String PARTY_TYPE_COLUMN = "\"PARTY_TYPE\"";

  //
  // Report table
  //
  public static final String REPORT_TABLE = "\"REPORT\"";
  // Report column names
  public static final String REPORT_ID_COLUMN = "\"REPORT_ID\"";
  public static final String REPORT_NAME_COLUMN = "\"REPORT_NAME\"";
  public static final String ENTITY_NAME_COLUMN = "\"ENTITY_NAME\"";
  public static final String REPORT_FILENAME_COLUMN = "\"REPORT_FILENAME\"";
  public static final String REPORT_TYPE_COLUMN = "\"REPORT_TYPE\"";
  public static final String MODIFIED_ON_COLUMN = "\"MODIFIED_ON\"";
  public static final String DESCRIPTION_COLUMN = "\"DESCRIPTION\"";
  // Report column lengths
  public static final int REPORT_NAME_COLUMN_LENGTH = 100;
  public static final int ENTITY_NAME_COLUMN_LENGTH = 100;
  public static final int REPORT_FILENAME_COLUMN_LENGTH = 100;
  public static final int REPORT_TYPE_COLUMN_LENGTH = 50;
  public static final int DESCRIPTION_COLUMN_LENGTH = 200;
  // Report column nullable (default is true)
  public static final boolean MODIFIED_ON_COLUMN_NULLABLE = false;

  //
  // User table
  //
  public static final String USER_TABLE = "\"USER\"";
  // User column names
  public static final String LOGIN_COLUMN = "\"LOGIN\"";
  public static final String SALT_COLUMN = "\"SALT\"";
  public static final String PASSWORD_COLUMN = "\"PASSWORD\"";
  // User column lengths
  public static final int LOGIN_COLUMN_LENGTH = 32;
  public static final int SALT_COLUMN_LENGTH = 32;
  public static final int PASSWORD_COLUMN_LENGTH = 128;

}
