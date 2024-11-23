<template>
  <main class="flex h-full flex-col">
    <HeaderBlock />
    <Section>
      <div class="mx-auto max-w-7xl items-center p-6 lg:px-8">
        <div class="sm:flex sm:items-center">
          <div class="sm:flex-auto">
            <h1 class="text-xl font-semibold text-gray-900">Pending Requests</h1>
            <p class="mt-2 text-sm text-gray-700">
              A list of all users and the events they would like to participate in.
            </p>
          </div>
        </div>
        <div class="mt-8 flow-root">
          <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
            <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
              <table class="min-w-full divide-y divide-gray-300">
                <thead>
                  <tr>
                    <th
                      scope="col"
                      class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0"
                    >
                      Name
                    </th>
                    <th
                      scope="col"
                      class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
                    >
                      Email
                    </th>
                    <th
                      scope="col"
                      class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
                    >
                      Interests
                    </th>
                    <th
                      scope="col"
                      class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
                    >
                      Languages
                    </th>
                    <th
                      scope="col"
                      class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
                    >
                      Event
                    </th>
                    <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-0">
                      <span class="sr-only">Accept Request</span>
                    </th>
                  </tr>
                </thead>
                <tbody class="divide-y divide-gray-200">
                  <tr v-for="person in people" :key="person.email">
                    <td
                      class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0"
                    >
                      {{ person.name }}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {{ person.email }}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {{ person.interests }}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {{ person.languages }}
                    </td>
                    <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                      {{ person.event }}
                    </td>
                    <td
                      class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0"
                    >
                      <a href="#" class="text-indigo-600 hover:text-indigo-900"
                        >Accept Request<span class="sr-only">, {{ person.name }}</span></a
                      >
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <!-- Events -->
        <div
          v-for="event in events"
          :key="event.id"
          class="border-b border-gray-200 py-4"
        >
          <Disclosure>
            <template #default="{ open }">
              <DisclosureButton
                class="flex justify-between items-center w-full bg-white py-3 text-lg font-medium text-gray-900 hover:bg-gray-50 rounded-md px-4"
              >
                <span>{{ event.name }}</span>
                <ChevronDownIcon
                  :class="{ 'rotate-180': open, 'rotate-0': !open }"
                  class="h-5 w-5 transition-transform duration-300"
                />
              </DisclosureButton>
              <DisclosurePanel class="px-4">
                <table class="min-w-full divide-y divide-gray-300">
                  <thead>
                    <tr>
                      <th
                        scope="col"
                        class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0"
                      >
                        Name
                      </th>
                      <th
                        scope="col"
                        class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
                      >
                        Email
                      </th>
                      <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-0">
                        <span class="sr-only">Accept Request</span>
                      </th>
                    </tr>
                  </thead>
                  <tbody class="divide-y divide-gray-200">
                    <tr v-for="person in people" :key="person.email">
                      <td
                        class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0"
                      >
                        {{ person.name }}
                      </td>
                      <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                        {{ person.email }}
                      </td>
                      <td
                        class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0"
                      >
                        <a href="#" class="text-indigo-600 hover:text-indigo-900"
                          >Verify Participation<span class="sr-only"
                            >, {{ person.name }}</span
                          ></a
                        >
                      </td>
                    </tr>
                  </tbody>
                </table>
              </DisclosurePanel>
            </template>
          </Disclosure>
        </div>
      </div>
    </Section>
  </main>
</template>

<script setup>
import HeaderBlock from "@/components/HeaderBlock.vue";
import { ref, onMounted } from "vue";
import { ChevronDownIcon, PlusIcon, MinusIcon } from "@heroicons/vue/20/solid";
import { Disclosure, DisclosureButton, DisclosurePanel } from "@headlessui/vue";
import { Dialog, TransitionRoot } from "@headlessui/vue";

const people = [
  {
    name: "Lindsay Walton",
    email: "lindsay.walton@example.com",
    interests: "Sports, Literature",
    languages: "English, German",
    role: "Member",
    event: "Baking Hour",
  },
  // More people...
];

//mock events
const events = ref([
  { id: 1, name: "Baking Hour", users: {} },
  { id: 2, name: "Reading Hour", users: {} },
]);
</script>
