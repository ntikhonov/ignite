/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef _IGNITE_EXAMPLES_ORGANIZATION
#define _IGNITE_EXAMPLES_ORGANIZATION

#include "ignite/binary/binary.h"

#include "ignite/examples/address.h"

namespace ignite
{
    namespace examples
    {
        struct Organization
        {
            Organization() :
                name(), addr()
            {
                // No-op.
            }

            Organization(const std::string& name) :
                name(name), addr()
            {
                // No-op.
            }

            Organization(const std::string& name, Address addr) :
                name(name), addr(addr)
            {
                // No-op.
            }

            std::string ToString() 
            {
                std::ostringstream oss;

                oss << "Organization [name=" << name << ", Address=" << addr.ToString() << "]";

                return oss.str();
            }

            std::string name;
            Address addr;
        };
    }
}

namespace ignite
{
    namespace binary
    {
        template<>
        struct BinaryType<ignite::examples::Organization>
        {
            static int32_t GetTypeId()
            {
                return GetBinaryStringHashCode("Organization");
            }

            static void GetTypeName(std::string& dst)
            {
                dst = "Organization";
            }

            static int32_t GetFieldId(const char* name)
            {
                return GetBinaryStringHashCode(name);
            }

            static int32_t GetHashCode(const ignite::examples::Organization& obj)
            {
                return 0;
            }

            static bool IsNull(const ignite::examples::Organization& obj)
            {
                return false;
            }

            static void GetNull(ignite::examples::Organization& dst)
            {
                dst = ignite::examples::Organization("", ignite::examples::Address());
            }

            static void Write(BinaryWriter& writer, const ignite::examples::Organization& obj)
            {
                writer.WriteString("name", obj.name);
                writer.WriteObject<ignite::examples::Address>("addr", obj.addr);
            }

            static void Read(BinaryReader& reader, ignite::examples::Organization& dst)
            {
                dst.name = reader.ReadString("name");
                dst.addr = reader.ReadObject<ignite::examples::Address>("addr");
            }
        };
    }
}

#endif