<template>
  <main class="flex h-full flex-col">
  <HeaderBlock />
  <Section>
  <div class="px-4 sm:px-6 lg:px-8">
    <div class="sm:flex sm:items-center">
      <div class="sm:flex-auto">
        <h1 class="text-base font-semibold text-gray-900">Pending Requests</h1>
        <p class="mt-2 text-sm text-gray-700">A list of all users and the events they would like to participate in.</p>
      </div>
      <div class="mt-4 sm:ml-16 sm:mt-0 sm:flex-none">
        <button type="button" class="block rounded-md bg-indigo-600 px-3 py-2 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Add user</button>
      </div>
    </div>
    <div class="mt-8 flow-root">
      <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
          <table class="min-w-full divide-y divide-gray-300">
            <thead>
              <tr>
                <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0">Name</th>    
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Email</th>
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Interests</th>
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Skills</th>
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Languages</th>
                <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-0">
                  <span class="sr-only">Accept Request</span>
                </th>
              </tr>
            </thead>
            <tbody class="divide-y divide-gray-200">
              <tr v-for="person in people" :key="person.email">
                <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0">{{ person.name }}</td>
                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{{ person.email }}</td>
                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{{ person.interests }}</td>         
                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{{ person.skills }}</td>
                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">{{ person.languages }}</td>
                <td class="relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
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
  </div>
  </Section>
  </main>
</template>

<script setup>

import HeaderBlock from "@/components/HeaderBlock.vue";

const people = [
  { name: 'Lindsay Walton', email: 'lindsay.walton@example.com', interests: 'Sports, Literature', Skills: 'Cooking', languages: 'English, German', role: 'Member' },
  // More people...
]

</script>