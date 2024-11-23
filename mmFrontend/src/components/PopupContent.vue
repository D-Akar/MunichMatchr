<template>
    <div class="popupContent flex flex-col">
        <h2 class="text-lg font-bold">{{ title }}</h2>
        <div class="mt-0">  
            <p class="text-gray-600">{{ description }}</p>
            <button class="text-white bg-blue-700 rounded-lg px-4 py-2 hover:text-blue-700 hover:bg-blue-200 transition-all ease-in-out">Sign up</button>
        </div>
    </div>
</template>

<script setup>
    defineProps(['title', 'description', 'details'])
</script>

<style>
.popupContent h2, p, button{
    margin-top: 0.5em !important;
    margin-bottom: 0px !important;
    margin-block-start: 0px;
    margin-block-end: 0px;
}


</style>